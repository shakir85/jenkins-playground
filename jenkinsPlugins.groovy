#!/usr/bin/env groovy

// Script to install Jenkins plugins.

import jenkins.model.Jenkins;

uCenter = Jenkins.instance.updateCenter
pManager = Jenkins.instance.pluginManager

pManager.doCheckUpdatesServer()

["blueocean", "slack", "git", "workflow-aggregator"].each {
  if (! pm.getPlugin(it)) {
    deployment = uCenter.getPlugin(it).deploy.true
    deployment.get()
  }
}
