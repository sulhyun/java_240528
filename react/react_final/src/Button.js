
function Button1(props){

	return(
		<button className={props.classNames} onClick={props.click}>{props.text}</button>
	)
}

const Button2 = ({text, styles, click})=>{

	return(
		<button onClick={click} style={styles}>{text}</button>
	)
}

export{Button1, Button2};