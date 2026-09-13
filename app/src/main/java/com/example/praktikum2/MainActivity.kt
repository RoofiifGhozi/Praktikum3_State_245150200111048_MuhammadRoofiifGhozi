package com.example.praktikum2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum2.ui.theme.Praktikum2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Praktikum2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainTabScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainTabScreen(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Counter", "Box Warna", "Profil")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFC))
    ) {
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color.White,
            contentColor = Color(0xFF2563EB)
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            when (selectedTab) {
                0 -> CounterTab()
                1 -> ColorToggleBoxTab()
                2 -> ProfileTab()
            }
        }
    }
}

@Composable
fun CounterTab() {
    var count by remember { mutableStateOf(0) }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Aplikasi Counter", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
            Spacer(modifier = Modifier.height(16.dp))
            Text("$count", fontSize = 48.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2563EB))
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(
                    onClick = { if (count > 0) count-- },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444))
                ) {
                    Text("- Kurang")
                }
                Button(
                    onClick = { count++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF22C55E))
                ) {
                    Text("+ Tambah")
                }
            }
        }
    }
}

@Composable
fun ColorToggleBoxTab() {
    var isRed by remember { mutableStateOf(true) }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Toggle Warna Box", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (isRed) Color(0xFFEF4444) else Color(0xFF22C55E))
                    .clickable { isRed = !isRed },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (isRed) "Warna: MERAH" else "Warna: HIJAU",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ProfileTab() {
    var isFollowed by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.kucing),
                contentDescription = "Foto Profil Kucing",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Muhammad Roofiif Ghozi", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F172A))
            Spacer(modifier = Modifier.height(2.dp))
            Text("245150200111048", fontSize = 14.sp, color = Color(0xFF64748B))
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                "Mahasiswa Teknik Informatika\nFakultas Ilmu Komputer, Universitas Brawijaya",
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFF334155)
            )

            Spacer(modifier = Modifier.height(20.dp))

            FollowButtonHoisted(isFollowed = isFollowed, onToggle = { isFollowed = !isFollowed })

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = if (isFollowed) "Anda mengikuti akun ini" else "Anda belum mengikuti akun ini",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = if (isFollowed) Color(0xFF16A34A) else Color(0xFFDC2626)
            )
        }
    }
}

@Composable
fun FollowButtonHoisted(isFollowed: Boolean, onToggle: () -> Unit) {
    Button(
        onClick = onToggle,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFollowed) Color(0xFF64748B) else Color(0xFF2563EB)
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth(0.7f)
    ) {
        Text(if (isFollowed) "Unfollow" else "Follow")
    }
}

@Preview(showBackground = true)
@Composable
fun MainTabScreenPreview() {
    Praktikum2Theme {
        MainTabScreen()
    }
}
