import { memo } from 'react';

function Input({ id, type = 'text', text, ref, onChange, value, error }) {
  return(
    <div>
      <label htmlFor={id} style={{display : 'inline-block', width : '80px'}}>{text}</label>
      <input type={type} id={id} ref={ref} value={value} onChange={onChange} />
      {error && <div style={{color : 'red'}}>{error}</div>}
    </div>
  );
}

export default memo(Input);