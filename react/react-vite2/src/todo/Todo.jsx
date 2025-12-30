/* 
input창과 버튼, h1태그로 된 화면을 구성
1. state변수 todo와 setTodo를 선언
2. input창의 값이 바뀌면 콘솔에 1이 출력되게 작성
3. 콘솔창에 1 대신에 input창에 입력된 값이 출력되도록 작성
4. state변수 tmp와 tmp와 setTmp를 선언
5. input창에 입력된 값을 state변수 tmp에 업데이트
6. 버튼을 클릭하면 콘솔에 2가 출력되도록 작성
7. 버튼을 클릭하면 state변수 todo의 값을 tmp의 값으로 업데이트
8. h1태그에 todo의 값을 화면에 출력
*/

import { useState } from 'react';

function Todo() {
  const [todo, setTodo] = useState("");
  const [tmp, setTmp] = useState("");

  const onChangeTmp = (e) => {
    setTmp(e.target.value);
  }

  const onClickBtn = () => {
    setTodo(tmp);
  }

  return (
    <>
      <div>
        <input onChange={onChangeTmp} />
        <button onClick={onClickBtn}>추가</button>
      </div>
      <h1>{todo}</h1>
    </>
  );
}

export default Todo;