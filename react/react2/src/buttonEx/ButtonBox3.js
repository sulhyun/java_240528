import './ButtonBox3.css';

/*
Button 컴포넌트를 만들어서 다양한 버튼을 생성할 수 있게 작성하세요.
다양한 버튼
	- 버튼 문구
	- 버튼 모양
	- type
*/

function ButtonBox3(){
	
	let style = {
		color : "black",
		"font-size" : "24px"
	}

	return(
		<form>
			<div>
				<input type="text" name="text" />
			</div>
			<Button type={"submit"} classNames={'btn br-5'} text={"전송"} />
			<Button type={"button"} classNames={'btn'} text={"버튼"} style={style} />
			<Button type={"reset"} classNames={'btn'} text={"리셋"} />
		</form>
	);
}

function Button({text, type, classNames, style}){
	return(
		<button type={type} className={classNames} style={style}>{text}</button>
	)
}

export default ButtonBox3;