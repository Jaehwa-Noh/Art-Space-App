//
//  ContentView.swift
//  ArtSpaceApp
//
//  Created by Jaehwa Noh on 11/6/23.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        MyGallary()
    }
}

struct MyGallary: View {
    var body: some View {
        VStack(alignment: .center) {
            MyPicture()
            PictureArtistAndName()
            NextAndPreviousButton()
        }
    }
}

struct MyPicture: View {
    var body: some View {
        Spacer()
        VStack(alignment: .leading) {
            Image("puppy")
                .resizable()
                .scaledToFit()
                .frame(maxWidth: .infinity, maxHeight: 400)
                .background(Color.white)
                .border(Color.teal, width: 3)
                .shadow(radius: 10)
            Text("From: ")
        }
        .padding(20)
    }
}

struct PictureArtistAndName: View {
    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                Text("어미개와 강아지")
                    .font(.system(size: 28))
                Spacer()
            }
            HStack {
                Text("이암")
                    .fontWeight(.bold)
                Text("(미정)")
                Spacer()
            }
        }
        .padding(20)
        .background(Material.ultraThick)
        .padding(.horizontal, 20)
    }
}

struct NextAndPreviousButton: View {
    var body: some View {
        Spacer()
        HStack {
            Button {
                
            } label: {
                Text("Previous")
                    .frame(maxWidth: .infinity)
            }
            .buttonStyle(.bordered)
            Button {
                
            } label: {
                Text("Next")
                    .frame(maxWidth: .infinity)
            }
            .buttonStyle(.bordered)
        }
        .padding(20)
    }
}

#Preview {
    ContentView()
}
