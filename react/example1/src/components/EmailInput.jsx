import { memo } from 'react';

function EmailInput({errors, id, domain, idRef, changeId, changeDomain}) {
  const domains = ["naver.com", "gmail.com", "hanmail.net", "kakao.com"];

  return(
    <div>
      <label htmlFor='id' style={{display : 'inline-block', width : '80px'}}>아이디</label>
      <input type='text' id='id' ref={idRef} value={id} onChange={changeId} />
      {domain === '' ? null : <span>@</span>}
      <select value={domain} onChange={changeDomain}>
        {domains.map((d) => {
          return <option key={d} value={d}>{d}</option>
        })}
        <option value=''>직접입력</option>
      </select>
      {errors.idError && <div style={{color : 'red'}}>{errors.idError}</div>}
    </div>
  );
}

export default memo(EmailInput);