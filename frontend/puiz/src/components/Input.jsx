import { useEffect, useRef, useState } from 'react';
import styled from "styled-components";

import useApi from "../hooks/useApi";
// import SockJS from 'sockjs-client';
// import { Stomp } from '@stomp/stompjs';

const Container = styled.div`
    display: flex;
    align-items: center;
`

function Input() {
    const commentApi = useApi(); //게임 참가 유저
    const [comment, setComment] = useState("");

    //댓글 작성	
	const handleComment = (e) => {
		setComment(e.target.value);
    };

    //댓글 등록	
	const make = () => {
		commentApi('POST', '/comment', comment);
    };
    
    return (
		<Container>				
            <input value={comment} type="text" placeholder="글을 남겨봐요" onChange={handleComment} />  
            <div onClick={make}> 등록 </div>
		</Container>
	);
}

export default Input; 