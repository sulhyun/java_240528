import { useState } from "react";

function List1(){

	const list = ['축구', '야구', '농구', '배구', '음악감상'];
	let [hobby, setHobby] = useState([]);
	let click = (e)=>{
		let {value, checked} = e.target;
		// value = e.target.value;
		// checked = e.target.cheked;
		let tmp = [...hobby];
		// checkbox가 체크된 상태이면 배열에 추가하고
		if(checked && hobby.length < 3){
			tmp.push(value);
		}
		// checkbox가 체크가 해제된 상태이면 배열에서 삭제
		else if(!checked){
			// let index = tmp.indexOf(value);
			// tmp.splice(index, 1);

			// value와 같지 않은 요소들만 이용해서 배열을 새로 만듬
			tmp = tmp.filter(item=> item != value);
		}
		else{
			alert('최대 3개까지 선택할 수 있습니다.')
		}
		setHobby(tmp);
	}

	let isDisabled = (value)=>{
		return hobby.length == 3 && !hobby.includes(value);
	}

	return(
		<div>
			<h1>당신의 취미는?</h1>
			{
				list.map((v,index)=>{
					return(
						<label key={index}>
							<input type="checkbox" value={v} onClick={click} disabled={isDisabled(v)} />{v}
						</label>
					)
				})
			}
			<ul>
				{
					hobby.map((v, index)=>{
						return(
							<li key={index}>{v}</li>
						)
					})
				}
			</ul>
		</div>
	)
}

export default List1;