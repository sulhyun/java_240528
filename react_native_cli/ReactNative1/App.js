import React from "react";
import { SafeAreaView } from "react-native-safe-area-context";
import Greeting from './components/Greeting';
import Box from './components/Box';
import Counter from './components/Counter';

function App() {
  return (
    <SafeAreaView style={{flex: 1}}>
      {/* <Greeting /> */}
      {/* <Box rounded size="large" /> */}
      <Counter />
    </SafeAreaView>
  );
}

export default App;
