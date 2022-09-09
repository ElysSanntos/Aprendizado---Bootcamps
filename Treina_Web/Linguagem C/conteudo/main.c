int str_conteudo( char *str1, char *str2)
{
    char *curr1 = str1, *s1, *s2;
    while(*curr1){
        for(s1 = curr1, s2 = str2; *s1 && *s2 && *s1 == *s2; ++s1, ++s2);
        if (!*s2) return curr1 - str1;
        curr1++;
    }
    return -1;
}
