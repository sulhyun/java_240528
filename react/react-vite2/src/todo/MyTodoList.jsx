import { useState } from 'react';

function MyTodoList() {
  const [todoList, setTodoList] = useState([]);
  const [text, setText] = useState("");
  const [id, setId] = useState(1);
  const [flag, setFlag] = useState(true);
  const [tmp, setTmp] = useState(-1);
  
  const onChangeText = (e) => {
    setText(e.target.value);
  }

  // 추가
  const add = () => {
    if(text.trim() === "") {
      return;
    }
    const tmp = {
      id : id,
      title : text,
      isDone : false
    }
    setTodoList([...todoList, tmp]);
    setId(prev => prev + 1);
    setText("");
  }

  // 삭제
  const del = (id) => {
    setTodoList((prev) => prev.filter((item) => item.id !== id))
  }

  // 수정
  const update = (item) => {
    setText(item.title);
    setTmp(item.id);
    setFlag(!flag);
  }

  const save = () => {
    setTodoList((prev) => {
      return prev.map((item) => {
        return(item.id === tmp ? { ...item, title: text } : item);
      })
    })
    setTmp(-1);
    setText("");
    setFlag(!flag);
  }

  // 토글(취소선)
  const toggle = (id) => {
    setTodoList((prev) => {
      return prev.map((item) => {
        return(item.id === id ? {...item, isDone : !item.isDone} : item);
      })
    })
  }

  return(
    <>
      <div>
        <h1>My Todo List</h1>
        <div>
          <input type="text" onChange={onChangeText} value={text} />
          {
           flag ? <button onClick={add}>추가</button> : <button onClick={save}>수정</button>
          }
        </div>
        <div>
          <h2>오늘의 할일</h2>
          {
            todoList.map((item) => {
              return (
                <div key={item.id}>
                  <span onClick={() => toggle(item.id)} style={{display: 'inline-block', width: '170px', textDecoration: item.isDone ? 'line-through' : 'none'}}>{item.id}. {item.title}</span>
                  <button onClick={() => update(item)}>수정</button>
                  <button onClick={() => del(item.id)}>삭제</button>
                </div>
              );
            })
          }
        </div>
      </div>
    </>
  );
}

export default MyTodoList;