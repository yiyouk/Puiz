import { useState } from 'react';

function useApi() {
  const [isLoading, setIsLoading] = useState(null);
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);

  // const baseURL = "https://kangwedance.site/dev"

  const baseURL = "http://43.202.222.228//api"


  // [1]. method는 restful api의 메소드, requestBody는 api요청 시 필요한 데이터(객체)
  async function fetchApi(method, url, requestBodyOrCallback, onSuccess) {
    // 3번째 인자 body인지 콜백인지 확인
    let requestBody;
    if (typeof requestBodyOrCallback === 'function') onSuccess = requestBodyOrCallback;
    else requestBody = requestBodyOrCallback;

    try {
      const response = await fetch( baseURL + url, {
        method: method,
        headers: {
          'Content-Type': 'application/json',
          Origin : `*`
        },
        body: JSON.stringify(requestBody)
      });
      if (method === 'POST' || method === 'PATCH') console.log('리퀘스트 바디(json) : ', JSON.stringify(requestBody))     
      if (!response.ok) throw new Error(`HTTP error: ${response.status}`)
      const json = await response.json();
      console.log(json)
      setData(json);
      if (onSuccess) onSuccess(json)

    } catch (error) {
      setError(error);
      console.error(error)
    } finally {
      setIsLoading(false);
    }
  }

  // [2]. api요청할 컴포넌트에서) 요청이 여러개이면, data:childData 이런식으로 꺼내면 된다.
  return { data, isLoading, error, fetchApi };
}

export default useApi;
