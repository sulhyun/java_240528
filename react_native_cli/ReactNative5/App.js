// 1. 라이브러리 설치
// 1-1. @react-navigation/native, react-native-screens, react-native-safe-area-context

// 4. 탭 네비게이터 라이브러리 설치
// 4-1. @react-navigation/bottom-tabs
// 4-2. (아이콘) react-native-vector-icons

import React from "react";

// 2. 라이브러리 적용
import { NavigationContainer } from "@react-navigation/native";

// 5. 라이브러리 적용
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";

// 7. 화면 만들기
import HomeScreen from './screens/HomeScreen';
import SearchScreen from './screens/SearchScreen';
import NotificationScreen from './screens/NotificationScreen';
import MessageScreen from './screens/MessageScreen';

// 9. 아이콘 라이브러리 적용
import Icon from 'react-native-vector-icons/MaterialIcons';

// 6. Tab 객체 만들기
const Tab = createBottomTabNavigator();

function App() {
  return(
    // 3. 컴포넌트 작성
    <NavigationContainer>
      {/* 8. 컴포넌트 작성 */}
      <Tab.Navigator 
        initialRouteName="Home"
        screenOptions={{
          tabBarActiveTintColor: '#fb8c00',
          tabBarShowLabel: false,
        }}
      >
        <Tab.Screen 
          name="Home" 
          component={HomeScreen}
          options={{
            tabBarIcon: ({color, size}) => (
              <Icon name="home" color={color} size={size} />
            )
          }}
        />
        <Tab.Screen 
          name="Search"
          component={SearchScreen} 
          options={{
            tabBarIcon: ({color, size}) => (
              <Icon name="search" color={color} size={size} />
            )
          }}
        />
        <Tab.Screen 
          name="Notification"
          component={NotificationScreen} 
          options={{
            tabBarIcon: ({color, size}) => (
              <Icon name="notifications" color={color} size={size} />
            )
          }}
        />
        <Tab.Screen 
          name="Message"
          component={MessageScreen} 
          options={{
            tabBarIcon: ({color, size}) => (
              <Icon name="message" color={color} size={size} />
            )
          }}
        />
      </Tab.Navigator>
    </NavigationContainer>
  );
}

export default App;