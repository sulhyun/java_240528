import { createContext, useState } from "react";
import { v4 as uuidv4 } from 'uuid';

const LogContext = createContext();

export function LogContextProvider({children}) {
  const [logs, setLogs] = useState(
    Array.from({length: 10})
      .map((_, index) => ({
        id: uuidv4(),
        title: `Log ${index}`,
        body: `log ${index}`,
        date: new Date().toISOString(),
      }))
      .reverse(),
  ); // 테스트 하기 위해 배열 초기화

  const onCreate = ({title, body, date}) => {
    const log = {
      id : uuidv4(),
      title,
      body,
      date,
    };
    setLogs([log, ...logs]);
  }; // 추가

  const onModify = (modified) => {
    const list = logs.map((log) => log.id === modified.id ? modified : log);
    setLogs(list);
  }; // 수정

  const onRemove = (id) => {
    const list = logs.filter((log) => log.id !== id);
    setLogs(list);
  } // 삭제
  return(
    <LogContext.Provider value={{logs, onCreate, onModify, onRemove}}>
      {children}
    </LogContext.Provider>
  );
};

export default LogContext;