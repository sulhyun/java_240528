import { NavigationContainer } from "@react-navigation/native";
import RootStack from './screens/RootStack';
import LogContext from './contexts/LogContext';

function App() {
  return (
    <NavigationContainer>
      <LogContext.Provider value="반갑습니다111">
        <RootStack />
      </LogContext.Provider>
    </NavigationContainer>
  );
}

export default App;