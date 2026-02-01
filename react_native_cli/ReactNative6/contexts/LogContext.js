// 1. 라이브러리 불러오기
import React, { createContext, useState } from "react";

// 2. 라이브러리 적용 (Context 만들기)
const LogContext = createContext();

// 3. Provider 컴포넌트로 감싸주기
export function LogContextProvider({children}) {
  const [text, setText] = useState('');
  return(
    <LogContext.Provider value={{text, setText}}>
      {children}
    </LogContext.Provider>
  );
}

export default LogContext;