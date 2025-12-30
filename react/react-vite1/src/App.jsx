import { useState } from 'react';
import './css/App.css';

const SEASON = [ 'spring', 'summer', 'fall', 'winter' ];

function App() {
  const [on , setOn] = useState(true);
  const [count, setCount] = useState(0);
  const [text, setText] = useState("");

  const onClickOn = () => {
    setOn(!on);
    setCount(prev => prev + 1);
  }

  const onChangeText = (e) => {
    setText(e.target.value);
  }

  return (
    <>
      <div>
        {
          SEASON.map((item, index) => {
            return(<p key={item}>{index + 1}번째 계절은 {item}</p>)
          })
        }
        <button onClick={onClickOn}>
          {on ? 'ON' : 'OFF'}
        </button>
        <div>
          카운트 : {count}
        </div>
        <div>
          <input type='text' onChange={onChangeText} />
          <p>{text}</p>
        </div>
      </div>
    </>
  );
}

export default App