import React, { createContext, useContext, useState } from "react";

const UserContext = createContext(null);

export function UserContextProvider({children}) {
  const [user, setUser] = useState(null);

  return(
    <UserContext.Provider
      children={children}
      value={{
        user,
        setUser
      }}
    />
  )
}

export function useUserContext() {
  const userContent = useContext(UserContext);
  if(!userContent) {
    throw new Error('UserContext.Provider is not found');
  }
  return userContent;
}