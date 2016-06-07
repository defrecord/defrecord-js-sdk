#!/bin/sh

mkdir -p dist
rm -f dist/*

lein do clean, cljsbuild once
cp resources/public/js/compiled/defrecord.logger.min.js dist/
cp resources/public/js/compiled/defrecord.logger.js dist/
