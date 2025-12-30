import { useState, useRef } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
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
    setErrors({});
    console.log(email, pw);
  }

  return (
    <>
      <div style={{textAlign : 'left'}} className='login-form'>
        <EmailInput errors={errors} id={id} domain={domain} ref={idRef} changeId={onChangeId} changeDomain={onChangeDomain} />
        <Input id='pw' type='password' text='비밀번호' ref={pwRef} onChange={onChangePw} value={pw} error={errors.pwError}/>
      </div>
      <div>
        <button onClick={login}>로그인</button>
        <button>회원가입</button>
      </div>
      <div>{email}</div>
    </>
  )
}

export default App
