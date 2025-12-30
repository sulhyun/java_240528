/*
사용자에게 입력받은 값을 리스트에 추가하고
화면에 보여주기
예)
입력창 :       추가
입력값
입력값
입력값
...
*/
import { useState } from 'react';

function ListEx1() {
  const [list, setList] = useState([]);
  const [text, setText] = useState("");

  const onChangeText = (e) => {
    setText(e.target.value);
  }

  const onClickBtn = () => {
    setList([...list, text]);
    setText("");
  }

  return(
    <>
      <div>
        <h1>내용 추가</h1>
        <input type="text" onChange={onChangeText} value={text} />
        <button onClick={onClickBtn}>추가</button>
      </div>
      <div>
        {
          list.map((item) => {
            return(<p>{item}</p>)
          })
        }
      </div>
    </>
  );
}

export default ListEx1;