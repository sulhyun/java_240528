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
		클릭했을 때 page가 최대페이지 - 5 보다 작거나 같으면 최대 페이지 - 5
6. 다음 버튼 클릭 이벤트를 등록
	- 클릭했을 때 page가 최대 페이지보다 작으면 page+1로 업데이트하고,
		클릭했을 때 page가 최대페이지보다 크면 최대 페이지 + 5
*/

import { useState } from 'react';

function ButtonEx2() {
  const [ page, setPage ] = useState(1);
  const [ max, setMax ] = useState(5);

  const down = () => {
    if(page > 1) {
      const current = page - 1;
      setPage(current);
      if(current <= max - 5 && max > 5) {
        setMax(prev => prev - 5);
      }
    }
  }

  const up = () => {
    const current = page + 1;
    setPage(current);
    if(current > max) {
      setMax(prev => prev + 5);
    }
  }

  return(
    <>
      <div>
        <button onClick={down}>이전</button>
        <span>{page} / {max}</span>
        <button onClick={up}>다음</button>
      </div>
    </>
  );
}

export default ButtonEx2;