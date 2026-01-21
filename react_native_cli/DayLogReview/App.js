import { NavigationContainer } from "@react-navigation/native";
import { StatusBar } from "react-native";
import RootStack from './screens/RootStack';
import { LogContextProvider } from "./contexts/LogContext";
import { SearchContextProvider } from "./contexts/SearchContext";

function App() {
  return (
    <NavigationContainer>
      <StatusBar barStyle="dark-content" />
      <SearchContextProvider>
        <LogContextProvider>
          <RootStack />
        </LogContextProvider>
      </SearchContextProvider>
    </NavigationContainer>
  );
}

export default App;