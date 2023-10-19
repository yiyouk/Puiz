import React from "react";
import styled from "styled-components";
import Input from "../components/Input";
import List from "../components/List";

const Bodysuit = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100vw;
    height: 100vh;
`


function MainPage() {
    return (
        <Bodysuit>
            <Input/>
            <List/>
        </Bodysuit>
    );
}

export default MainPage; 