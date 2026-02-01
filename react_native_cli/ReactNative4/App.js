// 1. 라이브러리 설치
// 1-1. @react-navigation/native, react-native-screens, react-native-safe-area-context

// 4. 드로어 네비게이터 라이브러리 설치
// 4-1. @react-navigation/drawer, react-native-gesture-handler, react-native-reanimated, react-native-worklets

import React from "react";
// 2. 라이브러리 적용
import { NavigationContainer } from "@react-navigation/native";

// 5. 라이브러리 적용
import { createDrawerNavigator } from "@react-navigation/drawer";

// 7. 화면 만들기
import HomeScreen from './screens/HomeScreen';
import SettingScreen from './screens/SettingScreen';

// 6. Drawer 객체 만들기
const Drawer = createDrawerNavigator();

function App() {
  return(
    // 3. 컴포넌트 작성
    <NavigationContainer>
      {/* 8. 컴포넌트 작성 */}
      <Drawer.Navigator
        initialRouteName="Home"
        drawerPosition="left"
        backBehavior="history"
        screenOptions={{
          drawerActiveBackgroundColor: '#fb8c00',
          drawerActiveTintColor: '#ffffff',
        }}
      >
        <Drawer.Screen 
          name="Home" 
          component={HomeScreen}
          options={{title: '홈'}}
        />
        <Drawer.Screen 
          name="Setting" 
          component={SettingScreen}
          options={{title: '설정'}} 
        />
      </Drawer.Navigator>
    </NavigationContainer>
  );
}

export default App;