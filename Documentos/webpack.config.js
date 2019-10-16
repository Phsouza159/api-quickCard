var path = require('path');

module.exports = {
    entry : {
        filename:  path.resolve(__dirname , './httpService.js'),
    } , 
    output : {
        path: path.resolve(__dirname , './'),
        filename: 'httpService.build.js',
    },
    module : {
        rules: [
            {
                test: /\.JS$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                query: {
                    presets: [
                        ['es2015' , {modules: false}]
                    ]
                }
            }
        ]
    },
    devServer: {
        contentBase: path.join(__dirname, './'),
        compress: true,
        port: 9000
      }
}