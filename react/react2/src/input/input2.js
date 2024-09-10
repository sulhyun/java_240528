import { useState } from "react";

/*
input 태그1 버튼
input 태그2
구성으로 화면을 생성
input태그1에 분을 입력하면 input태그2는 초로 변환해서 출력
*/

function Input2(){

	let [time, setTime] = useState(0);
	let [flag, setFlag] = useState(true);



	return(
		<div>
			<input type="text" disabled={!flag} value={flag?time:Math.floor(time/60)} onChange={e=>setTime(e.target.value)} />
			<label>분</label>
			<button onClick={()=>{setFlag(!flag); setTime(0)}}>전환</button>
			<br />
			<input type="text" disabled={flag} value={flag?time*60:time} onChange={e=>setTime(e.target.value)} />
			<label>초</label>
		</div>
	);
}

export default Input2;
