describe('defrecord.logger', function () {
  var scaffold = 'defrecord.logger scaffolding';
  require('testdom')('<html><body>' + scaffold + '</body></html>');

  var defrecord = require('../dist/defrecord.logger.min');

  it('should expose the namespace', function() {
    expect(document.getElementsByTagName('body')[0].innerHTML).toBe(scaffold);
    expect(typeof defrecord).toBe('object');
  });

});
