# pde-tools, Make your Eclipse more AWESOME!

Jeeeyul's PDE-tools provides some cool features for Eclipse Plugin Developers.

It was originated for me and my team. And it works great for me. I hope it helps you too.

<table style="border: none;">
  <tbody>
    <tr style="border:none;">
      <td style="vertical-align: middle; padding-top: 10px; border: none;">
        <a href='http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=367947' title='Drag and drop into a running Eclipse Indigo workspace to install PDE Tools'> 
          <img src='http://marketplace.eclipse.org/misc/installbutton.png'/>
        </a>
      </td>
      <td style="vertical-align: middle; text-align: left; border: none;">
        ← Drag it to your eclipse workbench to install! (I recommand Main Toolbar as Drop Target)
      </td>
    </tr>
  </tbody>
</table>

## Features
* [Generates Shared Image Constants for Plugin Developments](#shared-image-generator)
* [Icon Previewing Decorator](#icon-preview)
* [Enhanced Clipboard (History feature)](#clipboard-history)
* [Bundle Image Resource Navigator](#bundle-image-navigator)
* Screen shot tool

## Install
* Update Site(Eclipse 3.7 ~ 4.2): https://raw.github.com/jeeeyul/pde-tools/master/net.jeeeyul.pdetools.updatesite

## Clipboard History
Just press Control + Shift + V instead of Control + V, then you can paste contents from history of Clipboard.

![screenshot](https://raw.github.com/jeeeyul/pde-tools/master/net.jeeeyul.pdetools.resource/clipboard-history-paste.png)

It also provides view.

![screenshot](https://raw.github.com/jeeeyul/pde-tools/master/net.jeeeyul.pdetools.resource/clipboard-history-view.png)


## Icon Preview
Icon files are directly showed in Package Explorer or other navigators.

It's fast and light-weight, content change sensitive.

![screenshot](https://raw.github.com/jeeeyul/pde-tools/master/net.jeeeyul.pdetools.resource/icon-preview.png)

## Shared Image Generator
PDE Tools generates Java constants for monitored folder. It also support structured folders as sub palettes.

![screenshot](https://raw.github.com/jeeeyul/pde-tools/master/net.jeeeyul.pdetools.resource/shared-image-generator.png)

1. Select a plugin project and press right mouse button.
2. Select "Configure > Enable Shared Image Generator"
3. That's all.

![screenshot](https://raw.github.com/jeeeyul/pde-tools/master/net.jeeeyul.pdetools.resource/sig-config.png)


## Bundle Image Navigator

![screenshot](https://raw.github.com/jeeeyul/pde-tools/master/net.jeeeyul.pdetools.resource/bundle-image-navigator.png)

You can easily browse image files on plugins, and just drag and drop into your project to reuse icons.