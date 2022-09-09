

int main()
{
    char s1[20];
    char s2[20];
    printf("ola joao");
    scanf("%s", s1);
    printf("Digite outra string : ");
    scanf("%s", s2);
    printf("%ld", strstr(s1, s2) - s1);
}
