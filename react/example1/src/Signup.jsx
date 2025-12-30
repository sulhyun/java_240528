import { useState, useRef } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import EmailInput from './components/EmailInput';
import Input from './components/input';
import useInput from './hooks/useInput';
import useEmailInput from './hooks/useEmailInput';

function Signup() {
  const [nick, nickRef, onChangeNick] = useInput("");
  const [phone, phoneRef, onChangePhone] = useInput("");
  const [pw, pwRef, onChangePw] = useInput("");
  const [id, domain, idRef, onChangeId, onChangeDomain] = useEmailInput("");
  const [errors, setErrors] = useState({});
  const countRef = useRef(0);

  const email = `${id}@${domain}`;

  const login = () => {
    countRef.current += 1;
    console.log(countRef.current);
    if (!id?.trim()) {
      setErrors({idError : '아이디를 입력하세요'});
      idRef.current?.focus();
      return;
    }
    if (!pw?.trim()) {
      setErrors({pwError : '비밀번호를 입력하세요'});
      pwRef.current?.focus();
      return;
    }
    if (!nick?.trim()) {
      setErrors({nickError : '닉네임을 입력하세요'});
      nickRef.current?.focus();
      return;
    }
    if (!phone?.trim()) {
      setErrors({phoneError : '전화번호를 입력하세요'});
      phoneRef.current?.focus();
      return;
    }
    setErrors({});
    console.log(email, pw);
  }

  return (
    <>
      <div style={{textAlign : 'left'}} className='login-form'>
        <EmailInput errors={errors} id={id} domain={domain} ref={idRef} changeId={onChangeId} changeDomain={onChangeDomain} />
        <Input id='pw' type='password' text='비밀번호' ref={pwRef} onChange={onChangePw} value={pw} error={errors.pwError}/>
        <Input id='nick' text='닉네임' ref={nickRef} onChange={onChangeNick} value={nick} error={errors.nickError}/>
        <Input id='phone' type='tel' text='전화번호' ref={phoneRef} onChange={onChangePhone} value={phone} error={errors.phoneError}/>
      </div>
      <div>
        <button onClick={login}>회원가입</button>
        <button>로그인</button>
      </div>
      <div>{email}</div>
    </>
  );
}

export default Signup
