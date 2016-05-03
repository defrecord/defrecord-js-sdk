# defrecord Logger

## Goals

Simple logging service for predictive analytics and error detection.

## Installation

This can be consumed as a stand-along service.

    <script data-site="123456"
            src="//defrecord.s3-website-us-west-2.amazonaws.com/defrecord.logger.js"></script>

## Development

    lein figwheel

## Testing

    lein test

## Building

    lein cljsbuild once

## Deploying

### Setup

Ensure that all of the S3 configuration required for reading secure
credentials has been completed and that the following is in
.bash_profile: 

    eval "$(gpg-agent --daemon)"

The deployment can be run with: 

    lein deploy

