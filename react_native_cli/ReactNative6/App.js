import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import HomeScreen from './screens/HomeScreen';
import DetailScreen from './screens/DetailScreen';
import { LogContextProvider } from './contexts/LogContext';

const Stack = createNativeStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <LogContextProvider>
        <Stack.Navigator>
          <Stack.Screen
            name="Home"
            component={HomeScreen}
          />
          <Stack.Screen
            name="Detail"
            component={DetailScreen}
          />
        </Stack.Navigator>
      </LogContextProvider>
    </NavigationContainer>
  );
}

export default App;