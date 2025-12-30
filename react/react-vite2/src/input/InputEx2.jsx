/*
input 태그1 버튼
input 태그2
구성으로 화면을 생성
input태그1에 분을 입력하면 input태그2는 초로 변환해서 출력
*/

import { useState } from "react";

function InputEx2() {
  const [time, setTime] = useState(0);
  const [flag, setFlag] = useState(true);

  const onClickBtn = () => {
    setFlag(!flag);
    setTime(0);
  }

  return(
    <>
      <div>
        <input type="text" disabled={!flag} value={flag ? time : Math.floor(time / 60)} onChange={(e) => setTime(e.target.value)} />
        <label>분</label>
      </div>
      <div>
        <button onClick={onClickBtn} >변환</button>
      </div>
      <div>
        <input type="text" disabled={flag} value={flag ? time * 60 : time} onChange={(e) => setTime(e.target.value)} />
        <label>초</label>
      </div>
    </>
  );
}

export default InputEx2;