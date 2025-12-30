/*
사용자가 삭제 버튼을 누르면
리스트에서 값을 삭제하고
화면에 보여주기
아이템 삭제
아이템 삭제
아이템 삭제
...
*/

import { useState } from 'react';

function ListEx2() {
  const [list, setList] = useState(['Java', 'C', 'Python', 'JavaScript', 'C#', 'C++', 'Java']);

  const deleteItem = (index) => {
    setList((prev) => prev.filter((_, i) => i !== index))
  }

  return(
    <>
      <h1>내용 삭제</h1>
      <div>
        {
          list.map((item, index) => {
            return (
              <p key={index}>{index}. {item}<button onClick={() => deleteItem(index)}>삭제</button></p>
            );
          }) 
        }
      </div>
    </>
  );
}

export default ListEx2;