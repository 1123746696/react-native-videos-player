/**
 * Created by user on 2016/11/15.
 */
import React, {
    NativeModules
} from 'react-native';
let VideoPlayerModule = NativeModules.VideoPlayer;
let palyData={
    url:''
}
export default class VideoPlayer{
    static play(palyData:palyData) {
        VideoPlayerModule.play(palyData);
    }
};