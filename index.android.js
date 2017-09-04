/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Alert,
  Button
} from 'react-native';

import ToastExample from './ToastExample';
import ServiceExample from './ServiceExample';


export default class helloreactnative extends Component {

  _onStartServicePressButton() {
    ServiceExample.start();
  }

  _onStopServicePressButton() {
    ServiceExample.stop();
  }

  render() {
    return (
      <View style={styles.container}>

        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>

        <Button style={styles.buttonMargin}
            onPress={this._onStartServicePressButton}
            title="Start android service"
            color="#841584" />

        <Button style={styles.buttonMargin}
            onPress={this._onStopServicePressButton}
            title="Stop android service"
            color="#841584" />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  buttonMargin:{
    marginBottom:20
  }
});

AppRegistry.registerComponent('helloreactnative', () => helloreactnative);
