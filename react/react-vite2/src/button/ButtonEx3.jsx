/*
Button 컴포넌트를 만들어서 다양한 버튼을 생성할 수 있게 작성하세요.
다양한 버튼
	- 버튼 문구
	- 버튼 모양
	- type
*/

import './ButtonEx3.css';

function ButtonEx3() {
  return(
    <>
      <div>
        <Button className='button1' text='레드' type='button' />
        <Button className='button2' text='블루' type='submit' />
        <Button className='button3' text='그린' type='button' />
      </div>
    </>
  );
}

function Button({text, className, type}) {
  return (
    <button className={className} type={type}>{text}</button>
  );
}
export default ButtonEx3;