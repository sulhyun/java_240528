import React from "react";
import { View } from "react-native";
import SynchronousEx from './example/SynchronousEx';
import AsychronousEx from './example/AsynchronousEx';
import CallbackEx from './example/CallbackEx';
import PromiseEx from './example/PromiseEx';
import AsyncAwaitEx from './example/AsyncAwaitEx';
import AsyncStorageEx from './example/AsyncStorageEx';

function App() {
  return (
    <View>
      {/* <SynchronousEx /> */}
      {/* <AsychronousEx /> */}
      {/* <CallbackEx /> */}
      {/* <PromiseEx /> */}
      <AsyncAwaitEx />
      {/* <AsyncStorageEx /> */}
    </View>
  );
}

export default App;