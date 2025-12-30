/*
사용자가 수정 버튼을 누르면
리스트에서 값을 수정하고
화면에 보여주기
아이템 수정
아이템 수정
아이템 수정
...
*/

import { useState } from 'react';

function ListEx2() {
  const [list, setList] = useState(['Java', 'C', 'Python', 'JavaScript', 'C#', 'C++', 'Java']);
  const [text, setText] = useState("");
  const [index, setIndex] = useState(-1);

  const updateStart = (item, index) => {
    setText(item);
    setIndex(index);
  }

  const onChangeText = (e) => {
    setText(e.target.value);
  }

  const updateSave = () => {
    setList(list.map((item, i) => {
      return (index === i ? text : item);
    }));
    setIndex(-1);
    setText("");
  }

  return (
    <>
      <h1>내용 수정</h1>
      <input type='text' value={text} onChange={onChangeText} />
      <button onClick={updateSave}>수정</button>
      <div>
        {
          list.map((item, index) => {
            return(
              <p key={index}>{index}. {item}<button onClick={() => updateStart(item, index)}>수정</button></p>
            );
          })
        }
      </div>
    </>
  );
}

export default ListEx2;