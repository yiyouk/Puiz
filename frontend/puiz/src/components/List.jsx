import { useEffect, useRef, useState } from 'react';
import styled from "styled-components";

import useApi from "../hooks/useApi";

// import SockJS from 'sockjs-client';
// import { Stomp } from '@stomp/stompjs';

const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color : pink;
`

function List() {
    const stompRef = useRef(null);
    const commentApi = useApi(); //게임 참가 유저
    const [comments, setComments] = useState([]);
    const [ms, setMs] = useState();

    // useEffect(() => {
	// 	if (!stompRef.current) {
	// 		stompConnect();
    //     }
    // }, []);
    
    useEffect(() => { //메세지 오면 댓글 목록 갱신
        commentApi.fetchApi('GET', '/comment');
    }, [ms]);
    
	useEffect(() => {
		if(commentApi.data?.success){ //백에서 초기 리스트 받아오기
			setComments(commentApi.data.data);
		}
	}, [commentApi.data]);
    
    //웹소켓 연결
    // const stompConnect = () => {  
    //     try {
    //         const stomp = Stomp.over(() => {
    //             return new SockJS(`${baseURL}/ws/room`);
    //         });

    //         stomp.connect({}, () => {
    //             console.log('STOMP connected');
    //             stomp.subscribe(
    //                 `/sub/${roomId}`,
    //                 (Ms) => {
    //                     const msObj = JSON.parse(Ms.body);
    //                     setMs(msObj);
    //                     console.log('msObj ', msObj);
    //                 }, {}
    //             );
    //         });

    //         stompRef.current = stomp;

    //     } catch (error) {
    //         console.log('socket error: ', error);
    //     }
    // };

    return (
		<Container>				
			{comments.length ?
					comments.map((comment, index) => (
                        <div key={index}>
                            <p>{comment.id}</p>
                            <p>{comment.comment}</p>
						</div>
					))
					: <div>글이 없어</div>
			}
		</Container>
	);
}

export default List; 