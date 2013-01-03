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

* [Release Note](https://github.com/jeeeyul/pde-tools/wiki/Release-Note)
* [Trouble Shoot](https://github.com/jeeeyul/pde-tools/wiki/Trouble-Shoot)

## Features
* [Clipboard History](#clipboard-history)
* [Crazy Outline View](#crazy-outline)
* [Generates Shared Image Constants for Plugin Developments](#shared-image-generator)
* [Icon Previewing Decorator](#icon-preview)
* [Enhanced Clipboard (History feature)](#clipboard-history)
* [Bundle Image Resource Navigator](#bundle-image-navigator)
* Screen shot tool
* [Workspace Launcher](#workspace-launcher) **NEW!**

## Install
* Update Site(Eclipse 3.7 ~ 4.2): https://raw.github.com/jeeeyul/pde-tools/master/net.jeeeyul.pdetools.updatesite
* If you **updating PDE-Tools**, Please restart your eclipse with -clearPersistedState Options after update.
<pre>
eclipse -clearPersistedState
</pre>

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

## Crazy Outline
![Crazy Outline](https://raw.github.com/jeeeyul/pde-tools/master/net.jeeeyul.pdetools.resource/crazy-outline.png)

**Crazy Outline View** provides awesome way to navigate your source code.

It supports not only text based editor also support multi-paged editors.

<pre>
Window >> Show View >> Others... >> Plug-in Development >> Crazy Outline
</pre>
or
Just press Ctrl(or Command) + 3 and type crazy.

## Workspace Launcher
![launcher](https://raw.github.com/jeeeyul/pde-tools/master/net.jeeeyul.pdetools.resource/release-note/1.1/workspace-launcher.png)


## License
This software is distributed under the [EPL](http://www.eclipse.org/legal/epl-v10.html)

Basically this license allows almost everything what you want to except very rare case.
And It doesn't provide any warrenties.
Now you can launch other workspace rather than switch. It is more useful for MacOSX users.
