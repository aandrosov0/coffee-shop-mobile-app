package coffee.shop.app.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coffee.shop.app.R
import coffee.shop.app.themes.AppTheme

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.image_onboarding),
            contentDescription = stringResource(R.string.image_onboarding),
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp, vertical = 54.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.title_onboarding),
                modifier = Modifier.padding(bottom = 8.dp),
                color = Color(0xffffffff),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = stringResource(R.string.subtitle_onboarding),
                modifier = Modifier.padding(bottom = 32.dp),
                color = Color(0xffA2A2A2),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
            Button(
                onClick = { navController.navigate(""); TODO() },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.get_started),
                    modifier = Modifier.padding(vertical = 8.dp),
                )
            }
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() = AppTheme {
    OnboardingScreen()
}