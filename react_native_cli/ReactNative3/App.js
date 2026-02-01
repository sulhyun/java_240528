// 1. 라이브러리 설치
// 1-1. @react-navigation/native, react-native-screens, react-native-safe-area-context

// 4. 스택 네비게이터 라이브러리 설치
// 4-1. @react-navigation/native-stack

import React from "react";

// 2. 라이브러리 적용
import { NavigationContainer } from "@react-navigation/native";

// 5. 라이브러리 적용
import { createNativeStackNavigator } from "@react-navigation/native-stack";

// 7. 화면 만들기
import HomeScreen from './screens/HomeScreen';
import DetailScreen from './screens/DetailScreen';

// 6. Stack 객체 만들기
const Stack = createNativeStackNavigator();

function App() {
  return(
    // 3. 컴포넌트 작성
    <NavigationContainer>
      {/* 8. 컴포넌트 작성 */}
      <Stack.Navigator initialRouteName="Home">
        <Stack.Screen 
          name="Home" 
          component={HomeScreen} 
          options={{
            title: '홈',
            // Header 블록에 대한 스타일
            headerStyle: {
              backgroundColor: '#29b6f6'
            },
            // Header의 텍스트, 버튼들 색상
            headerTintColor: '#ffffff',
            // Header의 텍스트 스타일
            headerTitleStyle: {
              fontWeight: 'bold',
            }
          }}
        />
        <Stack.Screen 
          name="Detail" 
          component={DetailScreen}
          options={({route}) => ({
            title: `상세 정보 - ${route.params.id}`
          })} 
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;