import React from "react";
import { SafeAreaView } from "react-native-safe-area-context";
import Greeting from './components/Greeting';
import Box from './components/Box';
import Counter from './components/Counter';
import UuidEx from './exmple/UuidEx';
import DateFnsEx from './exmple/DateFnsEx';
import AnimationEx1 from './exmple/AnimationEx1';
import AnimationEx2 from './exmple/AnimationEx2';
import AnimationEx3 from './exmple/AnimationEx3';

function App() {
  return (
    <SafeAreaView style={{flex: 1}}>
      {/* <Greeting /> */}
      {/* <Box rounded size="large" /> */}
      {/* <Counter /> */}
      {/* <UuidEx /> */}
      {/* <DateFnsEx /> */}
      <AnimationEx1 />
      <AnimationEx2 />
      <AnimationEx3 />
    </SafeAreaView>
  );
}

export default App;
