import React from "react";
import {PageTitleContainer,PageTitleStyled, PageSutitleStyled} from './PageTitle.style';
interface PageTitleProps{
    title: String;
    subtitle: String;
}
const PageTitle: React.FC<PageTitleProps> = (props) => {
    return(
        <PageTitleContainer>
            <PageTitleStyled>{props.title}</PageTitleStyled>
            <PageSutitleStyled>{props.subtitle}</PageSutitleStyled>
        </PageTitleContainer>
    );
}

export default PageTitle;