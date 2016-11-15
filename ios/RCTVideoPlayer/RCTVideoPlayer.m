//
//  RCTVideoPlayer.m
//  RCTVideoPlayer
//
//  Created by user on 2016/11/14.
//  Copyright © 2016年 simple. All rights reserved.
//

#import "RCTVideoPlayer.h"
#import <AVKit/AVKit.h>
#import <AVFoundation/AVFoundation.h>
#import <MediaPlayer/MediaPlayer.h>
@implementation RCTVideoPlayer
RCT_EXPORT_MODULE();
RCT_EXPORT_METHOD(play:(NSDictionary *)play){
    NSString *videoURL = [play objectForKey:@"url"];
    AVPlayerViewController *avPlayer = [[AVPlayerViewController alloc] init];
    avPlayer.player = [[AVPlayer alloc] initWithURL:[NSURL URLWithString:videoURL]];
    avPlayer.videoGravity = AVLayerVideoGravityResizeAspect;
    avPlayer.showsPlaybackControls = true;
    
    UIViewController *presentingViewController = [[[UIApplication sharedApplication] delegate] window].rootViewController;
    while (presentingViewController.presentedViewController != nil) {
        presentingViewController = presentingViewController.presentedViewController;
    }
    [presentingViewController presentViewController:avPlayer animated:YES completion:nil];
    [avPlayer.player play];
    
}
@end
