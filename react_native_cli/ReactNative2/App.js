import React from "react";
import { SafeAreaProvider, SafeAreaView } from "react-native-safe-area-context";
import DateHead from './components/DateHead';

function App() {
  const today = new Date();
  return (
    <SafeAreaProvider>
      <SafeAreaView edges={['bottom']}>
        <DateHead date={today} />
      </SafeAreaView>
    </SafeAreaProvider>
  );
}

export default App;
