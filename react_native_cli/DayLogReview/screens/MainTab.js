import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import FeedsScreen from "./FeedsScreen";
import CalendarScreen from "./CalendarScreen";
import SearchScreen from "./SearchScreen";
import Icon from 'react-native-vector-icons/MaterialIcons';

const Tab = createBottomTabNavigator();

function MainTab() {

  return(
    <Tab.Navigator
      screenOptions={{
        tabBarShowLabel: false,
        tabBarActiveTintColor: '#009688'
      }}
    >
      <Tab.Screen 
        name="Feed" 
        component={FeedsScreen}
        options={{
          title: '피드',
          tabBarIcon: ({color, size}) => (
            <Icon name="view-stream" color={color} size={size} />
          )
        }}
      />
      <Tab.Screen 
        name="Calendar" 
        component={CalendarScreen} 
        options={{
          title: '달력',
          tabBarIcon: ({color, size}) => (
            <Icon name="event" color={color} size={size} />
          )
        }}
      />
      <Tab.Screen 
        name="Search" 
        component={SearchScreen} 
        options={{
          title: '검색',
          tabBarIcon: ({color, size}) => (
            <Icon name="search" color={color} size={size} />
          )
        }}
      />
    </Tab.Navigator>
  );
};

export default MainTab;