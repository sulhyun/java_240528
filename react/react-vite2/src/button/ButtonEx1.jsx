/*
버튼 현재페이지/최대페이지 버튼
으로 화면을 구성해서 
이전 버튼을 클릭하면 현재 페이지가 감소하고,
다음 버튼을 클릭하면 현재 페이지가 증가하도록 구성
1. state 변수 page와 setPage를 추가(초기값 1)
2. 1 대신 page가 화면에 출력되도록 수정
3. 최대 페이지를 변수로 설정(초기값 5)
4. 5대신 최대 페이지가 화면에 출력되도록 수정
5. 이전 버튼 클릭 이벤트를 등록
	- 클릭했을 때 page가 1보다 크면 page를 page-1로 업데이트하고,
		아니면 page를 최대페이지로 업데이트
6. 다음 버튼 클릭 이벤트를 등록
	- 클릭했을 때 page가 최대 페이지보다 작으면 page+1로 업데이트하고,
		아니면 page를 1페이지로 업데이트
*/

import { useState } from 'react';

function ButtonEx1() {
  const [page, setPage] = useState(1);
  const max = 5;

  const pageDown = () => {
    if(page > 1) {
      setPage(prev => prev - 1);
    }
    else {
      setPage(max);
    }
  }

  const pageUp = () => {
    if(page < max) {
      setPage(prev => prev + 1);
    }
    else {
      setPage(1);
    }
  }

  const pageMove = (amount) => {
    let current = page + amount;
    if(current == 0) {
      current = max;
    }
    if(current > max) {
      current = 1;
    }
    setPage(current);
  }

  return(
    <>
      <div>
        <h1>pageUp, pageDown 사용</h1>
        <button onClick={pageDown}>이전</button>
        <span>{page} / {max}</span>
        <button onClick={pageUp}>다음</button>
      </div>
      <div>
        <h1>pageMove 사용</h1>
        <button onClick={() => pageMove(-1)}>이전</button>
        <span>{page} / {max}</span>
        <button onClick={() => pageMove(1)}>다음</button>
      </div>
    </>
  );
}

export default ButtonEx1;