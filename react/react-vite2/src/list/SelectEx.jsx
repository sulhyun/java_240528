/*
Select 태그를 이용해서 과일은 선택할 수 있는 창을 만들고,
과일을 선택하면 h1태그에 선택한 과일이 출력되도록 작성
- 선택안함, 사과, 바나나, 오렌지
*/

import { useState } from 'react';

function SelectEx() {
  const [value, setValue] = useState("");

  const onChangeValue = (e) => {
    setValue(e.target.value);
  }

  return(
    <>
      <select onChange={onChangeValue}>
        <option value="">선택안함</option>
        <option value="apple">사과</option>
        <option value="banana">바나나</option>
        <option value="orange">오렌지</option>
      </select>
      <h1>{value}</h1>
    </>
  );
}

export default SelectEx;