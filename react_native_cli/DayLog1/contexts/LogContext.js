import React, { createContext, useEffect, useRef, useState } from "react";
import { v4 as uuidv4 } from 'uuid';
import logsStorage from '../storages/logsStorage';

const LogContext = createContext();

export function LogContextProvider({children}) {
  const [logs, setLogs] = useState([]);
  const initialLogsRef = useRef(null);

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

  // 불러오기
  useEffect(() => {
    const load = async () => {
      const savedLogs = await logsStorage.get();
      if(savedLogs) {
        setLogs(savedLogs);
      }
      initialLogsRef.current = savedLogs || [];
    }
    load();
  }, []);
  
  // 저장하기
  useEffect(() => {
    if(!initialLogsRef.current) {
      return;
    }
    logsStorage.set(logs);
  }, [logs]);
  
  return(
    <LogContext.Provider value={{logs, onCreate, onModify, onRemove}}>
      {children}
    </LogContext.Provider>
  );
};

export default LogContext;