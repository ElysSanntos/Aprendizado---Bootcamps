import React from "react";
import {SafeEnvironmentContainer} from './SafeEnvironment.style';
import {Container} from '@mui/material';
//Criando um componente
const SafeEnvironment = () =>{
return(
<SafeEnvironmentContainer>
    <Container>
        Ambiente Seguro   <i className={'twf-lock'} /> 
    </Container>
</SafeEnvironmentContainer>);
};

export default SafeEnvironment;